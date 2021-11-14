package com.example.uts_dharmasitumorang;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	int jmlBonus, totalBrng, HrgBrng;
	Button tampil, hitung, ulang, keluar;
	EditText kodeBrng, namaBrng, hrgBrng, jmlBrng, diskon, totalHrgBrng;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// EditTexts
		kodeBrng = (EditText)findViewById(R.id.kodeBarang);
		namaBrng = (EditText)findViewById(R.id.namaBarang);
		hrgBrng = (EditText)findViewById(R.id.hargaBarang);
		jmlBrng = (EditText)findViewById(R.id.jmlBeli);
		diskon = (EditText)findViewById(R.id.bonus);
		totalHrgBrng = (EditText)findViewById(R.id.totalBayar);
		
		// menampilkan data barang ( nama , harga )
		tampil = (Button)findViewById(R.id.btnTampil);
		tampil.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(kodeBrng.getText().toString().compareToIgnoreCase("TV-101") == 0) {
						namaBrng.setText("Televisi");
						hrgBrng.setText("2000000");
						
					} else if (kodeBrng.getText().toString().compareToIgnoreCase("KU-101") == 0) {
						namaBrng.setText("Kulkas");
						hrgBrng.setText("1500000");
						
					} else {
						Toast.makeText(getApplicationContext(), "Kode "+ kodeBrng.getText().toString() +" tidak ditemukan!" , Toast.LENGTH_LONG).show();
					}
					
				}
		 });
		
		 // menghitung bonus & total bayar
		 hitung = (Button)findViewById(R.id.btnHitung);
		 hitung.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					try {
						HrgBrng = Integer.parseInt(hrgBrng.getText().toString());
						totalBrng = Integer.parseInt(jmlBrng.getText().toString());
						
					} catch (Exception e) {
						// TODO: handle exception
						HrgBrng = 0;
						totalBrng = 0;
					}
					
					if (totalBrng >= 2) {
						jmlBonus = (int) (( HrgBrng * 0.05 ) * totalBrng);
					} else {
						jmlBonus = 0;
					}
					
					diskon.setText(jmlBonus + " ");
					totalHrgBrng.setText((HrgBrng * totalBrng) - jmlBonus + " ");
			
				}
		 });
		 
		 // mengulangi perhitungan barang
		 ulang = (Button)findViewById(R.id.btnUlang);
		 ulang.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					kodeBrng.setText("");
					namaBrng.setText("");
					hrgBrng.setText("");
					jmlBrng.setText("");
					diskon.setText("");
					totalHrgBrng.setText("");
					
					kodeBrng.requestFocus();
				}
		 });
		 
		 // keluar aplikasi
		 keluar = (Button)findViewById(R.id.btnKeluar);
		 keluar.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					ExitProgram();
					
				}
		 });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void ExitProgram() {
		finish();
	}

}
