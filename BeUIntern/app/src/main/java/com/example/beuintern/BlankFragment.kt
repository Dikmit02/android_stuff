package com.example.beuintern

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


class BlankFragment : Fragment(),RecyclerAdapter.ListItemClicked {
    private lateinit var recyclerH: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onListItemClicked(itemClickedPos: Int) {
     if(itemClickedPos == 0){
         recyclerH.adapter = RecyclerAdapterHori(listHori1,context)
     }
       else if(itemClickedPos == 1){
            recyclerH.adapter = RecyclerAdapterHori(listHori2,context)
        }
     else if(itemClickedPos == 2){
         recyclerH.adapter = RecyclerAdapterHori(listHori3,context)
     }
    }


    val lists : ArrayList<DataObj> = ArrayList()
    val listHori1 : ArrayList<DataObjForHorizontal> = ArrayList()
    val listHori2 : ArrayList<DataObjForHorizontal> = ArrayList()
    val listHori3 : ArrayList<DataObjForHorizontal> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater . inflate (R.layout.fragment_blank, container, false)
        // Inflate the layout for this fragment
        addDataToList()
        //For 1
        listHori1.add(DataObjForHorizontal(R.drawable.bangalorecircle1,"Text1"))
        //For 2
        listHori2.add(DataObjForHorizontal(R.drawable.bangalorecircle1,"Text1"))
        listHori2.add(DataObjForHorizontal(R.drawable.bangalorecircle1,"Text2"))
        //For 3
        listHori3.add(DataObjForHorizontal(R.drawable.bangalorecircle1,"Text1"))
        listHori3.add(DataObjForHorizontal(R.drawable.bangalorecircle1,"Text2"))
        listHori3.add(DataObjForHorizontal(R.drawable.bangalorecircle1,"Text3"))



  linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
        linearLayoutManager.reverseLayout = true

        val recyclerV = view.findViewById<RecyclerView>(R.id.rec1v)
        //For horizontal
        recyclerH = view.findViewById<RecyclerView>(R.id.rec2h)
        recyclerV.layoutManager = LinearLayoutManager(context)
        recyclerV.adapter = RecyclerAdapter(lists,context,this)

        recyclerH.layoutManager = linearLayoutManager


        return view
    }

    fun addDataToList(){
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text1",listHori1))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text2",listHori2))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text3",listHori3))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text4",listHori2))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text5",listHori2))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text6",listHori2))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text7",listHori2))
        lists.add(DataObj(R.drawable.bangalorecircle1,"Text8",listHori2))
    }



}
