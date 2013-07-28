package jump.digital.calculator;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button clicked;
	EditText EditTextValue;
	TextView TVValue;
	String InitialValue = "";
	char operand = ' ';
	int FinalValue, StoredValue;
	int TVC = 0;
	String TVStr = "";


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditTextValue = (EditText) findViewById(R.id.editText1);
		TVValue = (TextView) findViewById(R.id.textView1);		    
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	    {
		  String strValue = "";
		switch(v.getId())
		  {                    
			  case R.id.addition:    
				  calculate();                 
				  operand = '+';         
				  break;             
			  case R.id.subtract:                 
				  calculate();                 
				  operand = '-';                 
				  break;                
			  case R.id.division:                 
				  calculate();                 
				  operand = '/';                 
				  break;      
			  case R.id.multiply:
				  calculate();                 
				  operand = '*';
				  break;          
			  case R.id.equals:                 
				  calculate();                            
				  operand = '=';                            
				  break;                
			  case R.id.ButtonClear:                 
				  FinalValue=0;                 
				  InitialValue="0";                 
				  operand = ' ';                 
				  EditTextValue.setText("0");
				  TVValue.setText("");
				  TVC = 0;
				  TVStr = " ";
				  break;
			  default:
				  int intID = v.getId();
				  Button button = (Button) findViewById(intID);
				  if(v.getId() == intID)
				  strValue = button.getText().toString();
				  if(InitialValue=="0")
				  {                 
					  InitialValue=strValue;  
				  }
				  else
				  {                 
					  InitialValue+=strValue;
				  }             
				  if(InitialValue.length() <= 16)
				  {
				  EditTextValue.setText(InitialValue);
				  }
				  else
				  {
					  Toast.makeText(this, "Digit length limit", Toast.LENGTH_SHORT).show();
				  }
			          if (operand == '=') 
			          {                            
			        	  FinalValue = 0;                            
			        	  operand = ' ';                            
			          }                
				 break;
		  }
	    }
		  
	}
	
	public void calculate(){
		StoredValue = Integer.parseInt(InitialValue);
		InitialValue = "0";
		
		if(operand == ' ')
		{
			FinalValue = StoredValue;
		}
		else if(operand == '+')
		{
			FinalValue += StoredValue;

		}
		else if(operand == '-')
		{
			FinalValue -= StoredValue;

		}
		else if(operand == '/')
		{
			FinalValue /= StoredValue;

		}
		else if(operand == '*')
		{
			FinalValue *= StoredValue;

		}
		EditTextValue.setText("" + FinalValue);
	}

}
