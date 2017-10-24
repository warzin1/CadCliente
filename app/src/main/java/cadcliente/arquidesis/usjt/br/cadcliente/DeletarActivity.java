package cadcliente.arquidesis.usjt.br.cadcliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by warzin on 10/24/2017.
 */

public class DeletarActivity extends AppCompatActivity {

    public EditText editTextNome;
    public EditText editTextIdade;
    public EditText editTextCpf;
    public EditText editTextTelefone;
    public EditText editTextId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextIdade = (EditText)findViewById(R.id.editTextIdade);
        editTextCpf = (EditText)findViewById(R.id.editTextCpf);
        editTextTelefone = (EditText)findViewById(R.id.editTextTelefone);
        editTextId = (EditText)findViewById(R.id.editTextId);
    }


    public void consultarRegistro(View view){


        Cliente cliente;

        int id = Integer.parseInt(editTextId.getText().toString());

        if(id>0){

            // select * from cliente where id = X
            cliente = Cliente.findById(Cliente.class,id);

            if(cliente != null){

                editTextNome.setText(cliente.getNome());
                editTextCpf.setText(cliente.getCpf());
                editTextIdade.setText(cliente.getIdade()+"");
                editTextTelefone.setText(cliente.getTelefone());

            }


        }


    }

    public void deletarRegistro(View view){
        Cliente cliente;
        int id = Integer.parseInt(editTextId.getText().toString());
        if(id>0){
            cliente = Cliente.findById(Cliente.class,id);

            cliente.delete();

            Toast.makeText(this,"Registro deletado com sucesso ! Reg: "+cliente.getId(),Toast.LENGTH_LONG).show();

            finish();

        }



    }

}
