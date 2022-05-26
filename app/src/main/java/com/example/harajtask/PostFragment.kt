package com.example.harajtask

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.io.InputStream

class PostFragment : Fragment(R.layout.fragment_post), PostAdapter.OnItemClickListener{
    lateinit var postList : ArrayList<PostItem>
    lateinit var recycler: RecyclerView
    lateinit var adapter: PostAdapter

    var TAG = "Search for Post"


//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        menuInflater.inflate(R.menu.options_menu,menu)
//        val item = menu?.findItem(R.id.search)
//        val searchView = item?.actionView as SearchView
//        super.onCreateOptionsMenu(menu, inflater)
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postList = ArrayList<PostItem>()
        recycler = view.findViewById(R.id.recyclerView)
        adapter = PostAdapter(requireContext(),postList, this)
        recycler.layoutManager = LinearLayoutManager(requireContext())



        try {
            val jsonArray  = JSONArray(jsonDataFromAsset())
            for (i in 0 until jsonArray.length()) {
                val jsonPost = jsonArray.getJSONObject(i)
                val body = jsonPost.getString("body")
                val city = jsonPost.getString("city")
                val commentCount= jsonPost.getInt ("commentCount")
                val date = jsonPost.getInt("date")
                val thumbURL = jsonPost.getString("thumbURL")
                val title = jsonPost.getString("title")
                val username = jsonPost.getString("username")
                val postModel = PostItem(body,city,commentCount,date,thumbURL,title,username)
                postList.add(postModel)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        adapter.addPost(postList)
        recycler.adapter = adapter
        Log.d(TAG, "onViewCreated: ${postList}")
    }










//
//    fun getLocalJsonData(): String{
//        return try {
//            val jsonStream : InputStream = context?.assets!!.open("fileName")
//            String(jsonStream.readBytes())
//        }catch (exception:IOException){
//            exception.printStackTrace()
//            throw exception
//        }
//    }











    private fun jsonDataFromAsset(): String {
        return try {
            val jsonStream: InputStream = context?.assets!!.open("data.json")
            String(jsonStream.readBytes())
        } catch (exception: IOException) {
            exception.printStackTrace()
            throw exception
        }
    }

    override fun OnItemClick(postItem: PostItem) {
        findNavController().navigate(PostFragmentDirections.actionPostFragmentToPostInformationFragment(postItem))
    }

}