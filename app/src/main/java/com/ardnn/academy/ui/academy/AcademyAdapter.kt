package com.ardnn.academy.ui.academy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardnn.academy.R
import com.ardnn.academy.data.CourseEntity
import com.ardnn.academy.databinding.ItemsAcademyBinding
import com.ardnn.academy.ui.detail.DetailCourseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AcademyAdapter : RecyclerView.Adapter<AcademyAdapter.CourseViewHolder>() {
    private var listCourses = ArrayList<CourseEntity>()

    fun setCourses(courses: List<CourseEntity>?) {
        if (courses == null) {
            return
        }
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsAcademyBinding = ItemsAcademyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(listCourses[position])
    }

    override fun getItemCount(): Int {
        return listCourses.size
    }

    class CourseViewHolder(private val binding: ItemsAcademyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: CourseEntity) {
            with (binding) {
                tvItemTitle.text = course.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.deadline_date, course.deadline)
                Glide.with(itemView.context)
                    .load(course.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_bookmark_selector)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val toDetailCourse = Intent(itemView.context, DetailCourseActivity::class.java)
                    toDetailCourse.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
                    itemView.context.startActivity(toDetailCourse)
                }
            }
        }
    }
}