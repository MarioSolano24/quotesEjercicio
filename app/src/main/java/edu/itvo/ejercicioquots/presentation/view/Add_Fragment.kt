package edu.itvo.ejercicioquots.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.ejercicioquots.R
import edu.itvo.ejercicioquots.databinding.FragmentAddBinding
import edu.itvo.ejercicioquots.domain.model.QuoteModel
import edu.itvo.ejercicioquots.presentation.viewmodel.QuoteViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Add_Fragment : Fragment() {
    private var binding: FragmentAddBinding? = null
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(inflater, container, false)
        binding?.idButton?.setOnClickListener{
            actionButton()
        }

        return binding!!.root
    }
    private fun actionButton(){
        with(binding!!){
            if (validateStrings(idAutor.text.toString()) && validateStrings(idCitas.text.toString())) {
                val author = idAutor.text.toString()
                val quote = idCitas.text.toString()
                val objQuote = QuoteModel(0, author, quote)
                addQuote(objQuote)
                println("Se agregó cita")
            } else {
                println("Favor de ingresar todos los campos")
            }
        }
    }

    private fun addQuote(quoteModel: QuoteModel){
        lifecycleScope.launch {
           quoteViewModel.addQuote(quoteModel)
        }
    }

    private fun validateStrings(text: String)= text != ""
}