package com.br.AucelioBarbosa.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.br.AucelioBarbosa.R;
import com.br.AucelioBarbosa.dao.AlunoDAO;
import com.br.AucelioBarbosa.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String NOME_APPBAR = "Novo aluno";
    public static final String TITULO_APPBAR = NOME_APPBAR;
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_formulario_aluno);
        inicialiacao();
        configuracaoBotaoSalvar();
    }

    private void configuracaoBotaoSalvar() {
        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_btn_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno criarAluno = criaAluno();
                salvar(criarAluno);
            }
        });
    }

    private void inicialiacao() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salvar(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }

    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}