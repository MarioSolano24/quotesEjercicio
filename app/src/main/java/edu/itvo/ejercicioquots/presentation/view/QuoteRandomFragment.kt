package edu.itvo.ejercicioquots.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.ejercicioquots.R
import edu.itvo.ejercicioquots.databinding.FragmentQuoteRandomBinding
import edu.itvo.ejercicioquots.presentation.viewmodel.QuoteViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomFragment : Fragment() {
    private var binding: FragmentQuoteRandomBinding? = null
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuoteRandomBinding.inflate(inflater, container, false)
        quoteViewModel.randomQuote()
        observer()
        binding?.viewContainer?.setOnClickListener {
            quoteViewModel.randomQuote()
        }
        return binding!!.root
    }

    private fun observer(){
        lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding!!.tvQuote.text = it.quote
                binding!!.tvAuthor.text= it.author
            }
        }
    }
}