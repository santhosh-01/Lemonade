package com.example.lemonade

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val TAG = "MainActivity"

class ScoreFragment : Fragment() {

    private var squeezeCount: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Fragment Attached")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment Created")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Fragment View Created")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            squeezeCount = savedInstanceState.getString("SqueezeCount")
        }
        Log.d(TAG, "Fragment View Restored")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Fragment started")
        squeezeCount?.let { updateTotalScore(it) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "Fragment Activity Created")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Fragment Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Fragment Paused")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("SqueezeCount", squeezeCount)
        super.onSaveInstanceState(outState)
        Log.d(TAG, "Fragment Instance Saved")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Fragment Stopped")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Fragment View Destroyed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Fragment destroyed")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "Fragment Detached")
    }

    fun updateTotalScore(lemonSize: String) {
        val resultTextView = view?.findViewById<TextView>(R.id.result)
        if (lemonSize.isNotEmpty()) {
            squeezeCount = lemonSize
            resultTextView!!.text = "Remaining Lemon Squeeze $squeezeCount"
        }
        else {
            squeezeCount = null
            resultTextView!!.text = ""
        }
    }

}