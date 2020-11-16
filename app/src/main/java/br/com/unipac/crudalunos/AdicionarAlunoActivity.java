package br.com.unipac.crudalunos;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.com.unipac.crudalunos.infra.AlunoDatabase;
import br.com.unipac.crudalunos.model.domain.Aluno;

public class AdicionarAlunoActivity extends AppCompatActivity {
    Button savaBtn;
    EditText nomeEdt, curriculoEdt;
    private AlunoDatabase alunoDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_aluno);

        nomeEdt = (EditText) findViewById(R.id.nomeEdt);
        curriculoEdt = (EditText) findViewById(R.id.curriculoEdt);
        savaBtn = (Button) findViewById(R.id.savaBtn);

        alunoDatabase = AlunoDatabase.getInstance(this);

        savaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEdt.getText().toString();
                String curriculo = nomeEdt.getText().toString();

                Aluno aluno = new Aluno();
                aluno.setNome(nome);
                aluno.setCurriculo(curriculo);
                alunoDatabase.getAlunoDao().insert(aluno);

                Toast.makeText(AdicionarAlunoActivity.this, "Dados cadastrados", Toast.LENGTH_LONG).show();
            }
        });

    }
}