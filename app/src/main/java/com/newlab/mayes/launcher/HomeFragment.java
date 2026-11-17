package com.newlab.mayes.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.newlab.mayes.R;
import com.newlab.mayes.game.SAMP;
import com.newlab.mayes.launcher.util.RemoteConfigManager;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        View btnPlay = view.findViewById(R.id.btnPlay);

        View discordBtn = view.findViewById(R.id.discordBtn);
        View webBtn = view.findViewById(R.id.webBtn);
        View youtubeBtn = view.findViewById(R.id.youtubeBtn);

        discordBtn.setOnClickListener(v -> {
            String link = RemoteConfigManager.getString("discord");
            openUrl(link);
        });

        webBtn.setOnClickListener(v -> {
            String link = RemoteConfigManager.getString("website");
            openUrl(link);
        });

        youtubeBtn.setOnClickListener(v -> {
            String link = RemoteConfigManager.getString("youtube");
            openUrl(link);
        });

        btnPlay.setOnClickListener(v -> {
            if (!isAdded() || getActivity() == null) return;
            android.util.Log.d("HomeFragment", "Play button clicked");

            Intent intent = new Intent(getActivity(), SAMP.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        return view;
    }
    private void openUrl(String url) {
        if (url == null || url.trim().isEmpty()) return;
        try {
            android.net.Uri uri = android.net.Uri.parse(url.trim());
            if (uri.getScheme() == null) {
                uri = android.net.Uri.parse("https://" + url.trim());
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            android.util.Log.w("HomeFragment", "Cannot open URL: " + url, e);
        }
    }
}
