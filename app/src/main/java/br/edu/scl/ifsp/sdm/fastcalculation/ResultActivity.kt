package br.edu.scl.ifsp.sdm.fastcalculation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.sdm.fastcalculation.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getFloatExtra(EXTRA_RESULT, 0f)
        binding.resultTv.text = getString(R.string.result, result)

        binding.restartBt.setOnClickListener {

            val settings = intent.getParcelableExtra<Settings>(EXTRA_SETTINGS)
            val intent = Intent(this, GameActivity::class.java).apply {
            putExtra(EXTRA_SETTINGS, settings)

            }
            startActivity(intent)
            finish()
        }
    }

    companion object {
        private const val EXTRA_RESULT = "EXTRA_RESULT"
        private const val EXTRA_SETTINGS = "EXTRA_SETTINGS"

        fun newIntent(context: Context, result: Float, settings: Settings): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(EXTRA_RESULT, result)
                putExtra(EXTRA_SETTINGS, settings)
            }
        }
    }
}