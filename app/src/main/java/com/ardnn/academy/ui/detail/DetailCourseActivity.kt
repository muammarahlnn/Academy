package com.ardnn.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardnn.academy.R
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.databinding.ActivityDetailCourseBinding
import com.ardnn.academy.databinding.ContentDetailCourseBinding
import com.ardnn.academy.ui.reader.CourseReaderActivity
import com.ardnn.academy.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailCourseActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent
        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCourseViewModel::class.java]

        val adapter = DetailCourseAdapter()
        val extras = intent.extras
        if (extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId != null) {

                activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
                activityDetailCourseBinding.content.visibility = View.VISIBLE

                // generate modules depends on course id in view model
                viewModel.setSelectedCourse(courseId)
                viewModel.getModules().observe(this, { modules ->
                    activityDetailCourseBinding.progressBar.visibility = View.GONE
                    activityDetailCourseBinding.content.visibility = View.VISIBLE

                    adapter.setModules(modules)
                    adapter.notifyDataSetChanged()
                })

                // set course data
                viewModel.getCourse().observe(this, { course ->
                    populateCourse(course)
                })
            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter

            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(course: CourseEntity) {
        detailContentBinding.textTitle.text = course.title
        detailContentBinding.textDescription.text = course.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, course.deadline)

        Glide.with(this@DetailCourseActivity)
            .load(course.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStart.setOnClickListener {
            val toCourseReader = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            toCourseReader.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, course.courseId)
            startActivity(toCourseReader)
        }
    }

}