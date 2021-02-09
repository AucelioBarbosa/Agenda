package com.br.AucelioBarbosa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.br.AucelioBarbosa.R;
import com.br.AucelioBarbosa.dao.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_lista_aluno);

        configuracaoFabNovoAluno();
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        abreFromularioNovaActivity(dao, listaDeAlunos);
    }

    private void abreFromularioNovaActivity(AlunoDAO dao, ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,dao.todos()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuracaoFabNovoAluno() {
        FloatingActionButton btnNovoAluno = findViewById(R.id.accessibility_action_aluno_fab_novo_aluno);
        btnNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunoActivity.this,
                        FormularioAlunoActivity.class));
            }
        });
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}
