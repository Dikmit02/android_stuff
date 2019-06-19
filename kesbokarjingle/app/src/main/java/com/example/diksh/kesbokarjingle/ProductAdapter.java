package com.example.diksh.kesbokarjingle;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mctex;
    private List<Product> productList;

    public ProductAdapter(Context mctex, List<Product> productList) {
        this.mctex = mctex;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(mctex);
        View view=inflater.inflate(R.layout.example_item,null);
        ProductViewHolder holder=new ProductViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {

        Product product=productList.get(i);
        productViewHolder.textViewtitle.setText(product.getTitle());
        productViewHolder.shortdsec.setText(product.getShortdsec());
        productViewHolder.textviewshortheading.setText(String.valueOf(product.getTextviewshortheading()));
        productViewHolder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        productViewHolder.imageView.setImageDrawable(mctex.getResources().getDrawable(product.getImage(),null ));


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewtitle,shortdsec,textviewshortheading;
        Button call;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textViewtitle=itemView.findViewById(R.id.textViewTitle);
            shortdsec=itemView.findViewById(R.id.textViewShortDesc);
            textviewshortheading=itemView.findViewById(R.id.textviewshortheading);
            call=itemView.findViewById(R.id.callbutton);


        }
    }
}
