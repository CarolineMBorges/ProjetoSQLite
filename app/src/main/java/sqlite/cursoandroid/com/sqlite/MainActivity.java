package sqlite.cursoandroid.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) )");

            //inserir dados
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Caroline', 27) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Alberto', 25) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Jessica', 28) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Felipe', 33) ");

            //apagar tabela
            //bancoDados.execSQL("DROP TABLE pessoas");

            //deletar dados
            //bancoDados.execSQL("DELETE FROM pessoas WHERE nome  = 'Felipe' ");

            //atualizar dados
            //bancoDados.execSQL("UPDATE pessoas SET idade = 32 WHERE nome = 'Felipe' ");

            //recuperar dados da tabela - algumas consultas

            //consulta de nome
            /********************************************************************************************
             * String consulta = "SELECT nome, idade FROM pessoas " +
             *                   "WHERE nome = 'Caroline'";
             *********************************************************************************************/


            //consulta de nome - traz valores que tenham em alguma
            // parte do nome o que estiver entre as aspas simpes
            /********************************************************************************************
             * String consulta = "SELECT nome, idade FROM pessoas " +
             *                   "WHERE nome LIKE '%ca%";
             *********************************************************************************************/


            //consulta idade menor que 30
            /*******************************************************************************************
            * String consulta = "SELECT nome, idade FROM pessoas " +
            *                   "WHERE idade <30 ";
            ********************************************************************************************/


            //consulta de idades entre dois valores
            /********************************************************************************************
            * String consulta = "SELECT nome, idade FROM pessoas " +
            *                   "WHERE idade IN(28,35)";
            *********************************************************************************************/


            //consulta de idade entre dois valores
            /********************************************************************************************
             * String consulta = "SELECT nome, idade FROM pessoas " +
             *                   "WHERE idade BETWEEN 30 AND 35";
             *********************************************************************************************/


            //consulta de idade entre dois valores
            /********************************************************************************************
             * String consulta = "SELECT nome, idade FROM pessoas " +
             *                   "WHERE idade BETWEEN 30 AND 35";
             *********************************************************************************************/


            //ordenacoes - ASC = do menor para o maior, DESC - do maior para o menor
            //você pode colocar um limite ou não de itens a serem buscados
             String consulta = "SELECT nome, idade FROM pessoas " +
                                "WHERE 1=1 ORDER BY nome ASC ";




            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //'%ca%' - todos os nomes que tenham a sequencia de letras ca em algum lugar
            //Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas WHERE nome LIKE '%ca%'", null);

            //recuperar dados da tabela
            //Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas ", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");


            /*Quando fazemos a seleção de dados, ele para no último, então precisamos sempre voltar para
             * o inicio da lista
             * */
            cursor.moveToFirst();

            //exibir os dados
            while (cursor != null) {

                String nome = cursor.getString(indiceColunaNome);
                String idade = cursor.getString(indiceColunaIdade);
                String resultado = cursor.getString(indiceColunaId);

                Log.i("RESULTADO - id ", resultado + "nome: " +  nome + "idade: " + idade );



                //Move o cursor para o proximo item
                cursor.moveToNext();

            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
