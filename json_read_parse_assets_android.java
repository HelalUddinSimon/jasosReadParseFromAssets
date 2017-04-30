public class JasonReadAndParse extends AppCompatActivity{

  //json file which stored in "assets" folder in android studio
  /* {
  "energy":
  [{"id":1,"name":"Grid electricity"},
    {"id":2,"name":"Kerosene"},
    {"id":3,"name":"Solar"},
    {"id":4,"name":"Mini-grid"},
    {"id":5,"name":"Diesel generator"}]
}*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up0);


         String jsonString = loadJSONFromAsset();
                     
                       try {
                           JSONObject json = new JSONObject(jsonString);
                           JSONArray m_jArry = json.getJSONArray("energy");// json filename in assets folder
                           for (int i = 0; i < m_jArry.length(); i++) {
                               JSONObject inside = m_jArry.getJSONObject(i);

                               Toast.makeText(getApplicationContext(), inside.getString("name") , Toast.LENGTH_SHORT).show();
                           }


                       } catch (Exception e) {
                           e.printStackTrace();
                       }

}

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("abc");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


   
}