package com.example.betapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.betapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MatchBidBottomSheetFragment: BottomSheetDialogFragment() {

    private var listener: MatchBidBottomSheetListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.match_list_bottom_sheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle option selection
//        buttonOption1.setOnClickListener {
//            listener?.onOptionSelected("Option 1")
//            dismiss()
//        }
//
//        buttonOption2.setOnClickListener {
//            listener?.onOptionSelected("Option 2")
//            dismiss()
//        }
    }

//    // Optional: Attach the listener
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is MatchBidBottomSheetListener) {
//            listener = context
//        } else {
//            throw RuntimeException("$context must implement BottomSheetListener")
//        }
//    }
//
//    // Optional: Detach the listener
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }
}

interface MatchBidBottomSheetListener {

}
