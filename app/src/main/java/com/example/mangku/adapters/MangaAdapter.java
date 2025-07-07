package com.example.mangku.adapters; // Pastikan ini sesuai dengan lokasi file

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
// Import library untuk memuat gambar, contoh Glide:
// import com.bumptech.glide.Glide;
import com.example.mangku.R; // Pastikan R diimport dengan benar
import com.example.mangku.model.Manga; // Import model Manga Anda
import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    private Context context;
    private List<Manga> mangaList;
    private OnMangaClickListener listener;

    // Interface untuk menangani klik pada item
    public interface OnMangaClickListener {
        void onMangaClick(Manga manga);
    }

    public MangaAdapter(Context context, List<Manga> mangaList, OnMangaClickListener listener) {
        this.context = context;
        this.mangaList = mangaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_manga, parent, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangaViewHolder holder, int position) {
        Manga manga = mangaList.get(position);
        holder.bind(manga, listener);
    }

    @Override
    public int getItemCount() {
        return mangaList == null ? 0 : mangaList.size();
    }

    static class MangaViewHolder extends RecyclerView.ViewHolder {
        ImageView coverImageView;
        TextView titleTextView;
        TextView latestChapterTextView;

        public MangaViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImageView = itemView.findViewById(R.id.imageView_manga_cover);
            titleTextView = itemView.findViewById(R.id.textView_manga_title);
            latestChapterTextView = itemView.findViewById(R.id.textView_latest_chapter);
        }

        public void bind(final Manga manga, final OnMangaClickListener listener) {
            titleTextView.setText(manga.getTitle());
            latestChapterTextView.setText("Chapter Terbaru: " + manga.getLatestChapter());

            // Memuat gambar (Anda perlu menambahkan library seperti Glide atau Picasso)
            // Contoh dengan Glide (pastikan sudah ditambahkan di build.gradle):
                    /*
                    Glide.with(itemView.getContext())
                            .load(manga.getCoverUrl())
                            .placeholder(R.drawable.ic_placeholder_image) // ganti dengan placeholder Anda
                            .error(R.drawable.ic_broken_image) // ganti dengan gambar error Anda
                            .into(coverImageView);
                    */
            // Jika belum menggunakan library, Anda bisa set gambar dari drawable untuk sementara
            // coverImageView.setImageResource(R.drawable.nama_gambar_default_anda);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onMangaClick(manga);
                    }
                }
            });
        }
    }
}