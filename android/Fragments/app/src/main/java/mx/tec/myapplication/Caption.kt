package mx.tec.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class Caption : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // var view = layoutInflater.inflate()
        val view = inflater.inflate(R.layout.fragment_caption, container, false)
        val btnCaption = view.findViewById<Button>(R.id.btnCaption)
        btnCaption.setOnClickListener {
            Toast.makeText(context, "Text", Toast.LENGTH_SHORT).show()
        }

        // return inflater.inflate(R.layout.fragment_caption, container, false)
        return view
    }
}