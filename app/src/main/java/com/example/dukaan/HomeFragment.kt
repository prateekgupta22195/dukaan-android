package com.example.dukaan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {


    private val overviewAdapter by lazy {
        OverviewAdapter(overViewData["Last Month"]!!)
    }
    private val productAdapter by lazy {
        ProductAdapter(products)
    }

    private val rvOverView by lazy {
        requireView().findViewById<RecyclerView>(R.id.rvOverview)
    }

    private val tvViewAll by lazy {
        requireView().findViewById<TextView>(R.id.tvViewAll)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val tabLayout by lazy {
        requireView().findViewById<TabLayout>(R.id.tabLayout)
    }

    private val spinnerOverview by lazy {
        requireView().findViewById<Spinner>(R.id.spinnerOverview)
    }
    private val rvProducts by lazy {
        requireView().findViewById<RecyclerView>(R.id.rvProducts)
    }

    private val onItemSelectedListener = object : OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            overviewAdapter.list = overViewData[spinnerOverview.selectedItem as String]!!
            overviewAdapter.notifyDataSetChanged()
        }

    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setTabLayout()

        setOverview()


        // TODO: Use the ViewModel
    }

    private fun setOverview() {
        val dataAdapter: ArrayAdapter<String> =
            ArrayAdapter(
                requireContext(),
                R.layout.item_spinner,
                R.id.tvRange,
                overViewData.keys.toTypedArray()
            )
        dataAdapter.setDropDownViewResource(R.layout.item_drop_down_view)
        spinnerOverview.adapter = dataAdapter
        rvOverView.adapter = overviewAdapter
        spinnerOverview.onItemSelectedListener = onItemSelectedListener
    }

    private fun setTabLayout() {
        tabLayout.apply {
            addTab(newTab().apply {
                text = "Pending"
                tag = DeliveryStatus.PENDING
            })
            addTab(newTab().apply {
                text = "Accepted"
                tag = DeliveryStatus.ACCEPTED
            })
            addTab(newTab().apply {
                text = "Shipped"
                tag = DeliveryStatus.SHIPPED
            })
            addTab(newTab().apply {
                text = "Example(19)"
                tag = DeliveryStatus.ACCEPTED
            })
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val deliveryStatus = tab?.tag as DeliveryStatus
                val list = products.filter {
                    it.deliveryStatus == deliveryStatus
                }
                productAdapter.list = list
                productAdapter.notifyDataSetChanged()
            }
        })

        for (i in 0 until tabLayout.tabCount) {
            val tab = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as MarginLayoutParams
            when (i) {
                0 -> p.setMargins(32, 0, 12, 0)
                tabLayout.tabCount - 1 -> p.setMargins(12, 0, 32, 0)
                else -> p.setMargins(12, 0, 12, 0)
            }
            tab.requestLayout()
        }

        tabLayout.isSmoothScrollingEnabled = true

        tvViewAll.setOnClickListener { tabLayout.scrollX = tabLayout.width }

        rvProducts.adapter = productAdapter

        val marginVertical = resources.getDimensionPixelSize(R.dimen.size_12)
        val marginHorizontal = resources.getDimensionPixelSize(R.dimen.size_16)
        rvProducts.addItemDecoration(MarginItemDecoration(marginVertical, marginHorizontal))

    }




}