package cz.soft4you.remote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import cz.soft4you.remote.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Sender sender;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        sender = new Sender();

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imgBackward.setOnClickListener(v ->
                {
                    new Thread(() -> sender.send("backward")).start();
                }
        );
        binding.imgPlayPause.setOnClickListener(v ->
                {
                    new Thread(() -> sender.send("play-pause")).start();
                }
        );
        binding.imgForward.setOnClickListener(v ->
                {
                    new Thread(() -> sender.send("forward")).start();
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}