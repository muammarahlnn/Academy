package com.ardnn.academy.ui.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardnn.academy.R
import com.ardnn.academy.databinding.FragmentAcademyBinding
import com.ardnn.academy.utils.DataDummy

class AcademyFragment : Fragment() {

    private lateinit var fragmentAcademyBinding: FragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return fragmentAcademyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            // initialize adapter
            val courses = DataDummy.generateDummyCourses()
            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourses(courses)

            // set recyclerview
            with(fragmentAcademyBinding.rvAcademy) {
                layoutManager = LinearLayoutManager(context)
                adapter = academyAdapter
                setHasFixedSize(true)
            }
        }
    }

}