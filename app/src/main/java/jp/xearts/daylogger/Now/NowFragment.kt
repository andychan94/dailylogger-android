package jp.xearts.daylogger.Now

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.xearts.daylogger.R

/**
 * Created by nodir on 2017/12/13.
 */

public class NowFragment : Fragment() {
    private val TAG = "NowFragment"
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: started")
        return inflater?.inflate(R.layout.fragment_now, container, false)
    }
}