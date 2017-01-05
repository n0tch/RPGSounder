package gustavo.com.rpgsounder;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{


    ExpandableListView expandableListView;
    List<String> pai;
    Map<String, List<String>> topico;
    ExpandableListAdapter listAdapter;
    private MediaPlayer mediaPlayer;
    private ActionBarDrawerToggle mToggle;
    FloatingActionButton btnPause;
    private boolean isPaused = false;
    int pos;//variavel para guardar a posicao em que o audio foi pausado

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnPause = (FloatingActionButton) findViewById(R.id.btn_pause);

        DrawerLayout drawerLayout;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------MENU LATERAL-----------\\
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //----------Configuracao da Expandable List View----------\\

        //encontro o objeto do xml pelo find view by id
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        //preencho os valores da lista
        fillData();
        //coloco o conteudo das listas no expandable List view
        listAdapter = new MyExListAdapter(this, pai, topico);
        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if( mediaPlayer != null ){
                    mediaPlayer.stop();
                }

                switch(pai.get(groupPosition)){

                    case "Batalha":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Batalha 1":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.batalha1);
                                tocarSom();
                                break;
                            case "Batalha 2":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.batalha2);
                                tocarSom();
                                break;
                            case "Batalha Ao Longe":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.batalha_ao_longe);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Caverna":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Caverna Padrão":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.caverna_padrao);
                                tocarSom();
                                break;
                            case "Caverna Com Vento":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.caverna_vento);
                                tocarSom();
                                break;
                            case "Caverna Com Monstro":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.caverna_monstro);
                                tocarSom();
                                break;

                        }
                        break;

                    case "Cemitério":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Cemitério Com Chuva":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cemiterio_chuva);
                                tocarSom();
                                break;
                            case "Cemitério Com Vento":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cemiterio_vento);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Cidade":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Cidade de Dia 1":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_dia_1);
                                tocarSom();
                                break;
                            case "Cidade de Dia 2":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_dia_2);
                                tocarSom();
                                break;
                            case "Cidade de Dia 3":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_dia_3);
                                tocarSom();
                                break;
                            case "Cidade de Dia 4":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_dia_4);
                                tocarSom();
                                break;
                            case "Cidade de Noite 1":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_noite_1);
                                tocarSom();
                                break;
                            case "Cidade de Noite 2":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_noite_2);
                                tocarSom();
                                break;
                            case "Cidade de Noite 3":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cidade_noite_3);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Chuva":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Chuva Forte":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.chuva_forte);
                                tocarSom();
                                break;
                            case "Chuva Média":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.chuva_media);
                                tocarSom();
                                break;
                            case "Chuva Fraca":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.chuva_fraca);
                                tocarSom();
                                break;
                            case "Tempestade":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.tempestade);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Construções":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Casa Abandonada":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.casa_abandonada);
                                tocarSom();
                                break;
                            case "Casa Assombrada":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.casa_assombrada);
                                tocarSom();
                                break;
                            case "Castelo":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.castelo);
                                tocarSom();
                                break;
                            case "Laboratório Mágico":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.laboratorio_magico);
                                tocarSom();
                                break;
                            case "Taverna 1":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.taverna_1);
                                tocarSom();
                                break;
                            case "Taverna 2":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.taverna_2);
                                tocarSom();
                                break;
                            case "Templo":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.templo);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Floresta":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)){
                            case "Floresta Dia 1":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.floresta_tipo_01);
                                tocarSom();
                                break;
                            case "Floresta Dia 2":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.floresta_tipo_02);
                                tocarSom();
                                break;
                            case "Noite":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.floresta_noite);
                                tocarSom();
                                break;
                            case "Floresta Mágica":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.floresta_magica);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Vento":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition)) {
                            case "Vento Gelado":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vento_gelado);
                                tocarSom();
                                break;
                            case "Vento nas Alturas":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vento_alturas);
                                tocarSom();
                                break;
                            case "Vento no Litoral":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vento_litorial);
                                tocarSom();
                                break;
                        }
                        break;

                    case "Outros":
                        switch (topico.get(pai.get(groupPosition)).get(childPosition) ){
                            case "Cozinha":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cozinha);
                                tocarSom();
                                break;
                            case "Cripta":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cripta);
                                tocarSom();
                                break;
                            case "Falatório":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.falatorio);
                                tocarSom();
                                break;
                            case "Ferreiro":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ferreiro);
                                tocarSom();
                                break;
                            case "Vulcão":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vulcao);
                                tocarSom();
                                break;
                            case "Magia":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.magia);
                                tocarSom();
                                break;
                            case "Sussurro":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sussurro);
                                tocarSom();
                                break;
                            case "Bordel":
                                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bordel);
                                tocarSom();

                                break;
                        }
                        break;
                }

                return true;
            }
        });
    }

    public void fillData(){
        pai = new ArrayList<>();
        topico = new HashMap<>();

        pai.add("Batalha");//00
        pai.add("Caverna");//01
        pai.add("Cemitério");//02
        pai.add("Cidade");//03
        pai.add("Chuva");//04
        pai.add("Construções");//05
        pai.add("Floresta");//06
        pai.add("Vento");//07
        pai.add("Outros");//08

        List<String> batalha = new ArrayList<>();
        batalha.add("Batalha 1");
        batalha.add("Batalha 2");
        batalha.add("Batalha Ao Longe");
        topico.put(pai.get(0), batalha);

        List<String> caverna = new ArrayList<>();
        caverna.add("Caverna Padrão");
        caverna.add("Caverna Com Vento");
        caverna.add("Caverna Com Monstro");
        topico.put(pai.get(1), caverna);

        List<String> cemiterio = new ArrayList<>();
        cemiterio.add("Cemitério Com Chuva");
        cemiterio.add("Cemitério Com Vento");
        topico.put(pai.get(2), cemiterio);

        List<String> cidade = new ArrayList<>();
        cidade.add("Cidade de Dia 1");
        cidade.add("Cidade de Dia 2");
        cidade.add("Cidade de Dia 3");
        cidade.add("Cidade de Dia 4");
        cidade.add("Cidade de Noite 1");
        cidade.add("Cidade de Noite 2");
        cidade.add("Cidade de Noite 3");
        topico.put(pai.get(3), cidade);

        List<String> chuva = new ArrayList<>();
        chuva.add("Chuva Forte");
        chuva.add("Chuva Média");
        chuva.add("Chuva Fraca");
        chuva.add("Tempestade");
        topico.put(pai.get(4), chuva);

        List<String> construcoes = new ArrayList<>();
        construcoes.add("Casa Abandonada");
        construcoes.add("Casa Assombrada");
        construcoes.add("Castelo");
        construcoes.add("Laboratório Mágico");
        construcoes.add("Taverna 1");
        construcoes.add("Taverna 2");
        construcoes.add("Templo");
        topico.put(pai.get(5), construcoes);

        List<String> floresta = new ArrayList<>();
        floresta.add("Floresta Dia 1");
        floresta.add("Floresta Dia 2");
        floresta.add("Floresta Mágica");
        topico.put(pai.get(6), floresta);

        List<String> vento = new ArrayList<>();
        vento.add("Vento nas Alturas");
        vento.add("Vento Gelado");
        vento.add("Vento no Litoral");
        topico.put(pai.get(7), vento);

        List<String> outros = new ArrayList<>();
        outros.add("Cozinha");
        outros.add("Cripta");
        outros.add("Falatório");
        outros.add("Ferreiro");
        outros.add("Vulcão");
        outros.add("Magia");
        outros.add("Sussurro");
        outros.add("Bordel");
        topico.put(pai.get(8), outros);
    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setVolume(1.0f, 3.0f);
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sobre(MenuItem item){
        //Toast.makeText(MainActivity.this, "Falta criar a tela sobre", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, SobreActivity.class));
    }

    public void pause(View v){
        //Toast.makeText(MainActivity.this, "Falta criar a tela sobre", Toast.LENGTH_SHORT).show();
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                pos = mediaPlayer.getCurrentPosition();
                isPaused = true;
            }else if(isPaused){
                mediaPlayer.seekTo(pos);
                mediaPlayer.start();
                isPaused = false;
            }
        }
    }

    public void loop(View v){
        if(mediaPlayer != null){
            if(mediaPlayer.isLooping()){
                Toast.makeText(MainActivity.this, "Loop: Desativado", Toast.LENGTH_SHORT).show();
                mediaPlayer.setLooping(false);
            }else{
                Toast.makeText(MainActivity.this, "Loop: Ativado", Toast.LENGTH_SHORT).show();
                mediaPlayer.setLooping(true);
            }
        }
    }
}
