package com.beedev.mybook.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.beedev.core.extenstions.viewBinding
import com.beedev.mybook.R
import com.beedev.mybook.databinding.MyBookFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyBookFragment : Fragment(R.layout.my_book_fragment) {

    private val binding by viewBinding(MyBookFragmentBinding::bind)
    private val viewModel: MyBookViewModel by viewModel()

    private var myBookListAdapter: MyBookListAdapter? = null

    companion object {
        fun newInstance() = MyBookFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        viewModel.getMyBook()
        initAdapter()
        initView()
    }

    private fun initAdapter() {
        myBookListAdapter = MyBookListAdapter()
    }

    private fun initView() {
        context?.let { _context ->
            binding.myBookRecyclerView.apply {
                layoutManager = LinearLayoutManager(_context)
                adapter = myBookListAdapter
                setHasFixedSize(true)
            }
        }
    }

    private fun observeLiveData() {
        viewModel.bookList.observe(viewLifecycleOwner, {
            myBookListAdapter?.updateBookList(it)
        })
    }
}