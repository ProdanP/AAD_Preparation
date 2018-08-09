package eu.prodan.aad_preparation;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

import eu.prodan.aad_preparation.binding.BoardingPassInfo;
import eu.prodan.aad_preparation.binding.FakeDataUtils;
import eu.prodan.aad_preparation.databinding.ActivityMainBindingBinding;

/**
 * Created by Prodan Pavel on 09.08.2018.
 */

public class MainActivityBinding extends AppCompatActivity {
    private ActivityMainBindingBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_binding);
        BoardingPassInfo fakeInfo = FakeDataUtils.generateFakeBoardingPassInfo();
        displayBindingData(fakeInfo);
    }

    private void displayBindingData(BoardingPassInfo info){
       mBinding.textViewPassengerLabel.setText(info.passengerName);
       mBinding.textViewOriginCode.setText(info.originCode);
       mBinding.destinationCode.setText(info.destCode);
       mBinding.arrivalTime.setText(formatTheDate(info.arrivalTime));
       mBinding.departureTime.setText(formatTheDate(info.departureTime));
       mBinding.textViewBoardingTime.setText(formatTheDate(info.boardingTime));
       mBinding.gate.setText(info.departureGate);
       mBinding.seat.setText(info.seatNumber);
       mBinding.terminal.setText(info.departureTerminal);
    }

    private String formatTheDate(Timestamp timestamp){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", new Locale("RO", "RO"));
        return sdf.format(timestamp);
    }
}
