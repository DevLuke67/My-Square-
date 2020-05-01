package com.lucas.studio.assign

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.regex.Pattern

class CustomAdapter(var context: Context, var data:ArrayList<Contact>): BaseAdapter() {

    private class ViewHolder(row: View?){

        var Name: TextView
        var Phone: TextView
        var Phone2: TextView
        var Description: TextView
        init {

            this.Name = row?.findViewById(R.id.mTvName) as TextView
            this.Phone = row?.findViewById(R.id.mTvPhone) as TextView
            this.Phone2 = row?.findViewById(R.id.mTvPhone2) as TextView
            this.Description = row?.findViewById(R.id.mTvDec) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder:ViewHolder

        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.item_list,parent,false)
            viewHolder = ViewHolder(view)

            view.tag = viewHolder

        }else{

            view = convertView

            viewHolder = view.tag as ViewHolder

        }

        var item:Contact = getItem(position) as Contact

        viewHolder.Name.text = item.name
        viewHolder.Phone.text = item.phone
        viewHolder.Phone2.text = item.phone2
        viewHolder.Description.text = item.description


        return view as View

    }



    override fun getItem(position: Int): Any {

        return  data.get(position)

    }



    override fun getItemId(position: Int): Long {

        return position.toLong()

    }



    override fun getCount(): Int {

        return data.count()

    }

}