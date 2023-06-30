package com.project.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.mycalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
       Setting up onClickListener for Numericals
        */
        binding.btn1.setOnClickListener {
            binding.tvEnter.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.tvEnter.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.tvEnter.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.tvEnter.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.tvEnter.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.tvEnter.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.tvEnter.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.tvEnter.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.tvEnter.append("9")
        }
        binding.btn0.setOnClickListener {
            binding.tvEnter.append("0")
        }

        /*
        Setting up onCLickListener for Arthimetic Operators
        */

        binding.btnPlus.setOnClickListener {
            if (binding.tvEnter.text.isEmpty()){
                 binding.tvEnter.append("")
                return@setOnClickListener
            }
            if (binding.tvEnter.text.last() != '+')
                binding.tvEnter.append("+")

        }
        binding.btnMinus.setOnClickListener {
            if (binding.tvEnter.text.isEmpty()){
                binding.tvEnter.append("")
                return@setOnClickListener
            }
            if (binding.tvEnter.text.last() != '-')
                binding.tvEnter.append("-")
        }
        binding.btnMultiply.setOnClickListener {
            if (binding.tvEnter.text.isEmpty()){
                binding.tvEnter.append("")
                return@setOnClickListener
            }
            if (binding.tvEnter.text.last() != '*')
                binding.tvEnter.append("*")
        }



        /*
        Setting up onClickListener for EqualButton, DeleteButton and DotButton
        */
        binding.btnEqual.setOnClickListener {
            if (binding.tvEnter.text.isEmpty()){
                binding.tvEnter.append("")
                return@setOnClickListener
            }
            if (binding.tvEnter.text.lastOrNull()!in arrayOf('+','-','*','.')) {
                val enterText = binding.tvEnter.text.toString()
                val ans = ExpressionBuilder(enterText).build()
                val finalAnswer = ans.evaluate()
                binding.tvAnswer.text = finalAnswer.toString()
            }
        }

        binding.btnDelete.setOnClickListener {
            var text = binding.tvEnter.text.toString()
            if(text.isNotEmpty()) {
                text=  text.dropLast(1)
                binding.tvEnter.text = text
            }

        binding.btnDot.setOnClickListener {
            if (binding.tvEnter.text.isEmpty()){
                binding.tvEnter.append("")
                return@setOnClickListener
            }
            if (binding.tvEnter.text.lastOrNull() != '.')
                binding.tvEnter.append(".")
        }
        }

    }
}