import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.row_item;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder> {
   private List<row_item> listitems;
   private Context context;

    public RecyclerAdapter(List<row_item> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);
        return new Viewholder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
    row_item listitem = listitems.get(position);
    holder.textViewHead.setText(listitem.getHead());
    holder.textViewDesc.setText(listitem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        public TextView textViewHead,textViewDesc;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textViewHead=(TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc=(TextView)itemView.findViewById(R.id.textViewDesc);
        }

    }

}
