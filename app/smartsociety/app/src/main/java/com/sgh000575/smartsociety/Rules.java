package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    TextView rules_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_rules );

        rules_tv = findViewById( R.id.rules_tv );

        rules_tv.setText( "•\tBefore starting any civil work, carpentry, painting, renovation etc in their flats every member of the society needs to take proper permission of the committee. In case if anyone doesn’t follow this rule then he/she shall abide to pay certain amount of penalty.\n" +
                "•\tPenalties are applied against the damaged caused while shifting the household goods in lifts, corridors, garden areas etc by any member of the society.\n" +
                "•\tNo member can occupy the area near their front doors, corridors, passage for their personal usage.\n" +
                "•\tOwners who want to give their flats on rent should take proper permission from the authorized person of the society. All the details of rental agreement, documents of tenant’s bio-data, identity proofs should be submitted to the concern person on prior basis.\n" +
                "•\tEvery member of the society should park their vehicles in their respective allotted parking spaces only. If any illegal parking is done, then that person may cost a penalty for his mistake. Two wheelers should be parked separately. Only one or two vehicles of visitors or guests per flat are allowed to be parked in the premises of the apartment. Other vehicles are supposed to be parked out of the society’s boundary line.\n" +
                "•\tSalesmen, vendors or any other sellers are not allowed to enter the premises. Owners residing are not allowed to rent their flats for any commercial use as this might create trouble to other society members.\n" +
                "•\tAfter using the community hall for any event or function it should be cleaned and no damages should be caused. If any damage is cause strict action against the owner will be taken. Music systems should be played inside of the flats with low volume only.\n" +
                "•\tCricket, basket ball, badminton, football should be played only on the respective grounds. No children’s are allowed to play in the lobby area. In case of any property damage by the kid’s respective person or parents are held to be responsible.\n" +
                "•\tWastage and over usage of water is not allowed. Flat owners will be considered responsible for this act and they have to pay the penalty costs for the same.\n" +
                "•\tKeeping pets is allowed after submitting the required NOC to the society. But if pets like dogs are creating any kind of chaos and disturbance to other society members then the pets won’t be allowed.\n" +
                "•\tMaintenance charges should be paid from to time. If failed after multiple warnings, any legal action can be processed against the respective person.\n" +
                "•\tWashing of vehicles, cars, bikes etc in the premises is strictly prohibited. Instead you can use washing area of the society.\n" +
                "•\tSmoking in lobbies, passage is not allowed. If any irresponsible person is found smoking in the no smoking zone, he/she shall be charged with penalty.\n" +
                "\n" );
    }

}
