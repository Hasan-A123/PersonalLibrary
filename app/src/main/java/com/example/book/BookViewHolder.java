package com.example.book;

import static com.example.book.NewBookActivity.EXTRA_REPLY;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class BookViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

    private final TextView bookItemViewIsbnNo;
    private final TextView bookItemViewTitle;
    private final TextView bookItemViewAuthor;
    private final TextView bookItemViewDescription;
    private final TextView bookItemViewPublisher;
    private final TextView bookItemViewPublishedDate;
    private Book link;


    private BookViewHolder(View itemView) {
        super(itemView);
        bookItemViewIsbnNo = itemView.findViewById(R.id.textViewIsbnNo);
        bookItemViewTitle = itemView.findViewById(R.id.textViewTitle);
        bookItemViewAuthor = itemView.findViewById(R.id.textViewAuthor);
        bookItemViewDescription = itemView.findViewById(R.id.textViewDescription);
        bookItemViewPublisher = itemView.findViewById(R.id.textViewPublisher);
        bookItemViewPublishedDate = itemView.findViewById(R.id.textViewPublishedDate);
        itemView.setOnClickListener(this);


    }

    public void bind(Book book) {
        bookItemViewIsbnNo.setText(book.getIsbnNo());
        bookItemViewTitle.setText(book.getTitle());
        bookItemViewAuthor.setText(book.getAuthor());
        bookItemViewDescription.setText(book.getDescription());
        bookItemViewPublisher.setText(book.getPublisher());
        bookItemViewPublishedDate.setText(book.getPublishedDate());
        this.link = book;

    }


    static BookViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new BookViewHolder(view);
    }
    @Override
    public void onClick(View view) {
        int mPosition = getLayoutPosition();
        Toast.makeText(view.getContext(), "You selected " + mPosition, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(view.getContext(), NewBookActivity.class);
        intent.putExtra(EXTRA_REPLY, (Serializable) link);
        view.getContext().startActivity(intent);

    }

}
