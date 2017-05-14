package id.sch.smktelkom_mlg.privateassignment.xirpl416.privateproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondDetilPage extends AppCompatActivity {
    private static final String URL_DATA = "https://api.themoviedb.org/3/movie/top_rated?api_key=b4f368d6398ade60214a1de73e861e5a";
    public TextView textViewHeading2;
    public TextView textViewDesc2;
    public TextView textViewReview2;
    public ImageView imageViewDetail2;
    public String url;

    private Integer mPostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_detil2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mPostkey = getIntent().getExtras().getInt("blog_id");
        loadRecyclerView();
    }

    private void loadRecyclerView() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray array = jsonObject.getJSONArray("result");
                    JSONObject o = array.getJSONObject(mPostkey);

                    setTitle("Details");
                    textViewHeading2.setText(o.getString("title"));
                    textViewDesc2.setText("Popularity: " + o.getString("popularity"));
                    textViewReview2.setText("Overview: " + o.getString("overview"));
                    url = o.getJSONObject("link").getString("url");

                    Glide.with(SecondDetilPage.this)
                            .load("http://image.tmdb.org/t/p/w500" + o.getString("poster_path"))
                            .into(imageViewDetail2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
