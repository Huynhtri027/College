package eslam.example.com.college;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eslam.example.com.college.models.Posts;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEMS = 0;
    private static final int LOADING = 1;

    public  List<Posts> posts = new ArrayList<>();

    private boolean isLoadingAdded = false;

    public PostsAdapter() {

        posts.add(new Posts("djfjksdfjsdklfjsdkfsdk"));
        posts.add(new Posts("djfjksdfjsdklfjsdkfsdk"));
        posts.add(new Posts("djfjksdfjsdklfjsdkfsdk"));
        posts.add(new Posts("djfjksdfjsdklfjsdkfsdk"));

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEMS:
                View viewItem = inflater.inflate(R.layout.list_item_posts, parent, false);
                viewHolder = new PostsViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.loding_for_list, parent, false);
                viewHolder = new LoadingViewHolder(viewLoading);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Posts post = posts.get(position);

        switch (getItemViewType(position)) {
            case ITEMS:
                PostsViewHolder postsHolder = (PostsViewHolder) holder;

                postsHolder.postText.setText(post.getTextPost());
                break;
            case LOADING:
                LoadingViewHolder loadingHolder = (LoadingViewHolder) holder;

                loadingHolder.loadingData.setVisibility(View.VISIBLE);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return (posts != null) ? posts.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == posts.size() - 1) ? LOADING : ITEMS;
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView postText;

        public PostsViewHolder(View itemView) {
            super(itemView);
            postText = itemView.findViewById(R.id.post_text);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        TextView errorLoading;
        TextView errorInternet;
        ProgressBar loadingData;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            errorInternet = itemView.findViewById(R.id.error_internet_Loading);
            errorLoading = itemView.findViewById(R.id.error_Loading);
            loadingData = itemView.findViewById(R.id.progress_loading_posts_data);
        }
    }

    public  void addAll(List<Posts> mPosts){

       posts.addAll(mPosts);
       notifyDataSetChanged();
    }
}
