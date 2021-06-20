package com.subashrimal.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.subashrimal.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvclear.setOnClickListener {
            binding.tvexpression.text = ""
            binding.tvresult.text = ""
        }

        binding.tvone.setOnClickListener {
            binding.tvexpression.append("1")
        }
        binding.tvtwo.setOnClickListener {
            binding.tvexpression.append("2")
        }
        binding.tvthree.setOnClickListener {
            binding.tvexpression.append("3")
        }
        binding.tvfour.setOnClickListener {
            binding.tvexpression.append("4")
        }
        binding.tvfive.setOnClickListener {
            binding.tvexpression.append("5")
        }
        binding.tvsix.setOnClickListener {
            binding.tvexpression.append("6")
        }
        binding.tvseven.setOnClickListener {
            binding.tvexpression.append("7")
        }
        binding.tveight.setOnClickListener {
            binding.tvexpression.append("8")
        }
        binding.tvnine.setOnClickListener {
            binding.tvexpression.append("9")
        }

        binding.tvplus.setOnClickListener {
            binding.tvexpression.append("+")
        }
        binding.tvminus.setOnClickListener {
            binding.tvexpression.append("-")
        }
        binding.tvmultiply.setOnClickListener {
            binding.tvexpression.append("*")
        }
        binding.tvdivide.setOnClickListener {
            binding.tvexpression.append("/")
        }

        binding.tvdot.setOnClickListener {
            binding.tvexpression.append(".")
        }

        binding.tvzero.setOnClickListener {
            binding.tvexpression.append("0")
        }
        binding.tvback.setOnClickListener {
            val value = binding.tvexpression.text.toString()
            if (value.isNotEmpty()) {
                binding.tvexpression.text = value.substring(0, value.length - 1)
            }
        }

        binding.tvequal.setOnClickListener {
            val expression = ExpressionBuilder(binding.tvexpression.text.toString()).build()
            val result = expression.evaluate()
            val longresult = result.toLong()

            if (result == longresult.toDouble()) {
                binding.tvresult.text = longresult.toString()
            } else {
                binding.tvresult.text = result.toString()
            }

        }
    }
}