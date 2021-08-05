package com.picpay.desafio.android.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.remote.network.Status.ERROR
import com.picpay.desafio.android.data.remote.network.Status.LOADING
import com.picpay.desafio.android.data.remote.network.Status.SUCCESS
import com.picpay.desafio.android.databinding.ContactFragmentBinding
import org.koin.android.ext.android.inject

class ContactFragment : Fragment() {

    private val viewModel: ContactViewModel by inject()
    private val adapter: UserListAdapter by inject()

    private var _binding: ContactFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecycler()
        setUpObserver()
    }

    private fun setUpRecycler() {
        binding.contactRecyclerView.run {
            adapter = this@ContactFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setUpObserver() {
        viewModel.users.observe(
            viewLifecycleOwner,
            {

                it?.let { resource ->
                    when (resource.status) {
                        SUCCESS -> {
                            binding.contactLoader.visibility = View.GONE
                            resource.data?.let { users -> adapter.users = users }
                        }
                        ERROR -> {
                            binding.contactLoader.visibility = View.GONE
                            showErrorMessage(getString(R.string.default_request_error_message))
                        }
                        LOADING -> {
                            binding.contactLoader.visibility = View.VISIBLE
                        }
                    }
                }
            }
        )
    }

    private fun showErrorMessage(message: String) {
        Snackbar
            .make(binding.root, message, Snackbar.LENGTH_LONG)
            .setAction(R.string.try_again) { setUpObserver() }
            .show()
    }
}
