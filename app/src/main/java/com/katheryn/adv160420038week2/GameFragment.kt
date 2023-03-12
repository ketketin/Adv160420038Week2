package com.katheryn.adv160420038week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    var scoree = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var playerName = ""

        val randNum1 = (1..100).random()
        val randNum2 = (1..100).random()
        val total = (randNum1 + randNum2)

        txtNum1.text = randNum1.toString()
        txtNum2.text = randNum2.toString()

        txtResult.text = total.toString()

//        val answer = view.findViewById<TextInputLayout>(R.id.txtAnswer)

//        var score = 0
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"

            var score = GameFragmentArgs.fromBundle(requireArguments()).score
            scoree = score
        }

        btnSubmit.setOnClickListener {
                if (txtAnswer.text.toString() == total.toString()) {
                    scoree ++

                val action = GameFragmentDirections.actionGameFragmentSelf(playerName, scoree)
                Navigation.findNavController(it).navigate(action)
                }
                else {
                    val action = GameFragmentDirections.actionResultFragment(scoree)
                    Navigation.findNavController(it).navigate(action)
                }
        }

    }

}