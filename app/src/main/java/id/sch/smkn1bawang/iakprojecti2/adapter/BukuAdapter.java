package id.sch.smkn1bawang.iakprojecti2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smkn1bawang.iakprojecti2.R;
import id.sch.smkn1bawang.iakprojecti2.model.SemuabukuItem;

/**
 * Created by root on 04/12/17.
 */

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuHolder>{
    Context mContext;
    List<SemuabukuItem> semuabukuItemList;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public BukuAdapter(Context context, List<SemuabukuItem> bukuList){
        this.mContext = context;
        semuabukuItemList = bukuList;
    }

    @Override
    public BukuAdapter.BukuHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buku, parent, false);
        return new BukuHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BukuAdapter.BukuHolder holder, int position){
        final SemuabukuItem semuabukuItem = semuabukuItemList.get(position);
        holder.tvNamaPemilik.setText(semuabukuItem.getNamaPemilik());
        holder.tvNamaBuku.setText(semuabukuItem.getBuku());

        String namaPemilik = semuabukuItem.getNamaPemilik();
        String firstCharNamaPemilik = namaPemilik.substring(0,1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNamaPemilik, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount(){ return semuabukuItemList.size();}

    public class BukuHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ivTextDrawable)
        ImageView ivTextDrawable;
        @BindView(R.id.tvNamaPemilik)
        TextView tvNamaPemilik;
        @BindView(R.id.tvNamaBuku)
        TextView tvNamaBuku;

        public BukuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public int getColor(){
        String color;

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);
        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);
        return  colorAsInt;
    }

}
