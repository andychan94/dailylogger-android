package jp.xearts.daylogger

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import jp.xearts.daylogger.History.HistoryFragment
import jp.xearts.daylogger.Now.NowFragment
import jp.xearts.daylogger.Overview.OverviewFragment
import jp.xearts.daylogger.Settings.SettingsFragment
import q.rorbin.badgeview.Badge
import q.rorbin.badgeview.QBadgeView


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var mViewPagerAdapter: ViewPagerAdapter

    @BindView(R.id.bottom_navigation) lateinit var mNavigation: BottomNavigationViewEx
    @BindView(R.id.view_pager_main) lateinit var mViewPager: CustomViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        Log.d(TAG, "onCreate: started")

        mNavigation.enableAnimation(false)
        mNavigation.enableShiftingMode(false)
        mNavigation.enableItemShiftingMode(false)
        mNavigation.setTextVisibility(false)
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        addBadgeAt(0, 1) // add a red "1" badge to the first menu item
        mViewPager.setSwipeable(false)
        setupViewPager(mViewPager)
    }

    /**
    Bottom navigation setup
     */
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_now -> {
                mViewPager.setCurrentItem(0, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                mViewPager.setCurrentItem(1, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_overview -> {
                mViewPager.setCurrentItem(2, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                mViewPager.setCurrentItem(3, false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
    Add a badge to the bottom navigation
     */
    private fun addBadgeAt(position: Int, number: Int): Badge {
        return QBadgeView(this)
                .setBadgeNumber(number)
                .setGravityOffset(12f, 2f, true)
                .bindTarget(mNavigation.getBottomNavigationItemView(position))
    }

    /**
    Viewpager setup
     */
    private fun setupViewPager(viewPager: ViewPager) {
        val nowFragment = NowFragment()
        val historyFragment = HistoryFragment()
        val overviewFragment = OverviewFragment()
        val settingsFragment = SettingsFragment()

        mViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        mViewPagerAdapter.addFragment(nowFragment)
        mViewPagerAdapter.addFragment(historyFragment)
        mViewPagerAdapter.addFragment(overviewFragment)
        mViewPagerAdapter.addFragment(settingsFragment)
        viewPager.adapter = mViewPagerAdapter
    }
}
