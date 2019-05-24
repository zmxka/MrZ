package cn.example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrz.R;

import org.example.entity.Fruit;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    public RecycleViewAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    private OnMyItemClickLister lister;

    public void setOnMyitemClickLsiter(OnMyItemClickLister itemClickLister){
        lister = itemClickLister;
    }

    public interface OnMyItemClickLister{
        void onClick(View view, int i);
    }



    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.litsview_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder ViewHolder, final int i) {
        Fruit fruit = fruitList.get(i);
        ViewHolder.imageView.setImageResource(fruit.getImageId());
        ViewHolder.textView.setText(fruit.getName());
        if (lister != null){
            ViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lister.onClick(v,i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.ListView_item_img);
            textView = (TextView) itemView.findViewById(R.id.ListView_item_name);
        }
    }
}
