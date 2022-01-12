package com.ardnn.academy.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardnn.academy.R
import com.ardnn.academy.data.source.local.entity.CourseEntity
import com.ardnn.academy.databinding.FragmentBookmarkBinding
import com.ardnn.academy.viewmodel.ViewModelFactory

class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentBookmarkBinding= FragmentBookmarkBinding.inflate(layoutInflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

            // initialize adapter
            val adapter = BookmarkAdapter(this)

            fragmentBookmarkBinding.progressBar.visibility = View.VISIBLE
            viewModel.getBookmarks().observe(viewLifecycleOwner, { bookmarks ->
                fragmentBookmarkBinding.progressBar.visibility = View.GONE
                adapter.setCourses(bookmarks)
                adapter.notifyDataSetChanged()
            })

            // set recyclerview
            with (fragmentBookmarkBinding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                this.adapter = adapter
                setHasFixedSize(true)
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireActivity())
                .setText(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, course.title))
                .startChooser()
        }
    }

}