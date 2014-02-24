package com.Dragonfly.LDRoutine;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.graphics.PorterDuff;

public class LDRoutine extends Activity {
    /** Called when the activity is first created. */
	Button BHighWalk;
	Button BHighWalkAdd;
	Button BLowWalk;
	Button BLowWalkAdd;
	Button BRises;
	Button BRisesAdd;
	Button BBows;
	Button BBowsAdd;
	Button BQuickBows;
	Button BQuickBowsAdd;
	Button BStop;
	Button BUndo;
	Button BPlay;
	Button BLeft;
	Button BRight;
	
	TextView theList;
	TextView theListChecker;
	MediaPlayer mp = new MediaPlayer();
	boolean playing;
	boolean listPlaying;
	int lineNumber;
	
	int screenState;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        lineNumber = 0;
        playing = false;
        listPlaying = false;
        screenState = 0;
        
        theList = (TextView)findViewById(R.id.list);
        theList.setTextSize(14);
        theList.setText("");
        
        theListChecker = (TextView)findViewById(R.id.listChecker);
        theListChecker.setTextSize(14);
        theListChecker.setText("");
        
        BLeft = (Button)findViewById(R.id.left);
        BLeft.getBackground().setColorFilter(0xFFB0C4DE, PorterDuff.Mode.MULTIPLY);
        BLeft.setOnClickListener(new goLeft());
        BRight = (Button)findViewById(R.id.right);
        BRight.getBackground().setColorFilter(0xFFB0C4DE, PorterDuff.Mode.MULTIPLY);
        BRight.setOnClickListener(new goRight());
        
        BRises = (Button)findViewById(R.id.rises);
        BRises.setOnClickListener(new playRises());
        
        BRisesAdd = (Button)findViewById(R.id.risesadd);
        BRisesAdd.getBackground().setColorFilter(0xFF778899, PorterDuff.Mode.MULTIPLY);
        BRisesAdd.setOnClickListener(new RisesAdd());
        
        BHighWalk = (Button)findViewById(R.id.highWalk);
        BHighWalk.setOnClickListener(new playHighWalk());
        
        BHighWalkAdd = (Button)findViewById(R.id.highWalkadd);
        BHighWalkAdd.getBackground().setColorFilter(0xFF778899, PorterDuff.Mode.MULTIPLY);
        BHighWalkAdd.setOnClickListener(new HighWalkAdd());
        
        BLowWalk = (Button)findViewById(R.id.lowWalk);
        BLowWalk.setOnClickListener(new playLowWalk());
        
        BLowWalkAdd = (Button)findViewById(R.id.lowWalkadd);
        BLowWalkAdd.getBackground().setColorFilter(0xFF778899, PorterDuff.Mode.MULTIPLY);
        BLowWalkAdd.setOnClickListener(new LowWalkAdd());
        
        BBows = (Button)findViewById(R.id.bow);
        BBows.setOnClickListener(new playBows());
        
        BBowsAdd = (Button)findViewById(R.id.bowadd);
        BBowsAdd.getBackground().setColorFilter(0xFF778899, PorterDuff.Mode.MULTIPLY);
        BBowsAdd.setOnClickListener(new BowsAdd());
        
        BQuickBows = (Button)findViewById(R.id.quickBows);
        BQuickBows.setOnClickListener(new playQuickBows());
        
        BQuickBowsAdd = (Button)findViewById(R.id.quickBowsadd);
        BQuickBowsAdd.getBackground().setColorFilter(0xFF778899, PorterDuff.Mode.MULTIPLY);
        BQuickBowsAdd.setOnClickListener(new QuickBowsAdd());
        
        BStop = (Button)findViewById(R.id.stop);
        BStop.getBackground().setColorFilter(0xFFFFA500, PorterDuff.Mode.MULTIPLY);
        BStop.setOnClickListener(new stopAllSound());
        BStop.setEnabled(false);
        
        BUndo = (Button)findViewById(R.id.undo);
        BUndo.getBackground().setColorFilter(0xFFFFB6C1, PorterDuff.Mode.MULTIPLY);
        BUndo.setOnClickListener(new undoList());
        BUndo.setEnabled(false);
        
        BPlay= (Button)findViewById(R.id.play);
        BPlay.getBackground().setColorFilter(0xFF32CD32, PorterDuff.Mode.MULTIPLY);
        BPlay.setOnClickListener(new playList());
        BPlay.setEnabled(false);
    }
    
    private class goLeft implements OnClickListener{
    	public void onClick(View v) {
    		if(screenState == 1)
    		{
	    		BBows.setText("Bows");
	            BRises.setText("Rises");
	            BHighWalk.setText("High Walk");
	            BLowWalk.setText("Low Walk");
	            BQuickBows.setText("Quick Bows");
    			BLowWalk.setVisibility(View.VISIBLE);
    			BRises.setVisibility(View.VISIBLE);
    			BLowWalkAdd.setVisibility(View.VISIBLE);
    			BRisesAdd.setVisibility(View.VISIBLE);
	            screenState = 0;
    		}
    		else if(screenState == 0)
    		{
    			BBows.setText("Approach");
    			BQuickBows.setText("Cleaning");
    			BHighWalk.setText("Drum Roll");
    			BLowWalk.setVisibility(View.INVISIBLE);
    			BRises.setVisibility(View.INVISIBLE);
    			BLowWalkAdd.setVisibility(View.INVISIBLE);
    			BRisesAdd.setVisibility(View.INVISIBLE);
    			screenState = 1;
    		}
    	}
    }
    
    private class goRight implements OnClickListener{
    	public void onClick(View v) {
    		if(screenState == 0)
    		{
    			BBows.setText("Approach");
    			BQuickBows.setText("Cleaning");
    			BHighWalk.setText("Drum Roll");
    			BLowWalk.setVisibility(View.INVISIBLE);
    			BRises.setVisibility(View.INVISIBLE);
    			BLowWalkAdd.setVisibility(View.INVISIBLE);
    			BRisesAdd.setVisibility(View.INVISIBLE);
    			screenState = 1;
    		}
    		else if(screenState == 1)
    		{
	    		BBows.setText("Bows");
	            BRises.setText("Rises");
	            BHighWalk.setText("High Walk");
	            BLowWalk.setText("Low Walk");
	            BQuickBows.setText("Quick Bows");
    			BLowWalk.setVisibility(View.VISIBLE);
    			BRises.setVisibility(View.VISIBLE);
    			BLowWalkAdd.setVisibility(View.VISIBLE);
    			BRisesAdd.setVisibility(View.VISIBLE);
	            screenState = 0;
    		}
    	}
    }
    
    private class playList implements OnClickListener{
        int x;
        String temp;
        int lastPosition;
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(lineNumber!=0&&!listPlaying)
        	{
        		theListChecker.setText(">");
	        	temp = (String) theList.getText();
	        	lastPosition = 2;
	        	x = 2;
	        	listPlaying = true;
	        	BRises.setEnabled(false);
	        	BRisesAdd.setEnabled(false);
    			BBows.setEnabled(false);
    			BBowsAdd.setEnabled(false);
    			BQuickBows.setEnabled(false);
    			BQuickBowsAdd.setEnabled(false);
    			BHighWalk.setEnabled(false);
    			BLowWalk.setEnabled(false);
    			BLowWalkAdd.setEnabled(false);
    			BHighWalkAdd.setEnabled(false);
    			BUndo.setEnabled(false);
    			BPlay.setEnabled(false);
    			BStop.setEnabled(true);
    			
	        	next();
	        	//theListChecker.setText("");
        	}
        }
        
        public void next()
        {
        	while(!temp.substring(x, x+1).equals("|") && x != temp.length()-2)
        	{
        		x++;
        	}
        	
    		if(temp.substring(x, x+1).equals("|") || x == temp.length()-2)
    		{
    			String read;
    			if(x == temp.length()-2)
    			{
    				read = temp.substring(lastPosition, temp.length()-1);
    			}
    			else
    			{
    				read = temp.substring(lastPosition, x-2);
    			}
            	if(playing) {
    	        	mp.stop();
    	        	mp.release();
    	        	playing = false;
            	}
            	mp = new MediaPlayer();
            	if(read.equalsIgnoreCase("Rises"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.rises);
            	}
            	if(read.equalsIgnoreCase("Low Walk"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.lwsound);
            	}
            	if(read.equalsIgnoreCase("High Walk"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.hwsound);
            	}
            	if(read.equalsIgnoreCase("Bows"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.bowsound);
            	}
            	if(read.equalsIgnoreCase("Quick Bows"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.quickbows);
            	}
            	if(read.equalsIgnoreCase("Approach"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.approach);
            	}
            	if(read.equalsIgnoreCase("Cleaning"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.cleaning);
            	}
            	if(read.equalsIgnoreCase("Drum Roll"))
            	{
            		mp = MediaPlayer.create(getBaseContext(), R.raw.drumroll);
            	}
                mp.start();
                playing = true;
                mp.setOnCompletionListener(new OnCompletionListener() {
                @Override
    	            public void onCompletion(MediaPlayer mp) {
    	                mp.release();
    	                playing = false;
    	                if(x != temp.length()-1)
    	                {
    	                	next();
    	                	theListChecker.setText("\n" + theListChecker.getText());
    	                }
    	                else
    	                {
    	                	theListChecker.setText("");
    	                	listPlaying = false;
    	    	        	BRises.setEnabled(true);
    	    	        	BRisesAdd.setEnabled(true);
    	        			BBows.setEnabled(true);
    	        			BBowsAdd.setEnabled(true);
    	        			BQuickBows.setEnabled(true);
    	        			BQuickBowsAdd.setEnabled(true);
    	        			BHighWalk.setEnabled(true);
    	        			BLowWalk.setEnabled(true);
    	        			BLowWalkAdd.setEnabled(true);
    	        			BHighWalkAdd.setEnabled(true);
    	        			BUndo.setEnabled(true);
    	        			BPlay.setEnabled(true);
    	        			BStop.setEnabled(false);
    	                }
    	            }
                });

            	lastPosition = x+1;
            	x++;
    		}
        }
     }
    
    private class undoList implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(lineNumber!=0&&!listPlaying)
        	{
	        	String temp = (String) theList.getText();
	        	int newLineNumber = 0;
	        	for(int x = 0; x < temp.length()-1; x++)
	        	{
	        		if(temp.substring(x, x+1).equals("|"))
	        		{
	        			newLineNumber++;
	        		}
	        		if(newLineNumber == lineNumber)
	        		{
	        			theList.setText(temp.substring(0,x-1));
	        			newLineNumber++;
	        			lineNumber--;
	        			if(lineNumber == 0)
	        			{
	        				BUndo.setEnabled(false);
	        				BPlay.setEnabled(false);
	        			}
	        		}
	        	}
        	}
        }
     }
    
    private class RisesAdd implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying&&lineNumber<18)
        	{
	        	theList.setText(theList.getText() + " |Rises\n");
	        	lineNumber++;
	        	BUndo.setEnabled(true);
	        	BPlay.setEnabled(true);
        	}
        }
     }
    
    private class HighWalkAdd implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying&&lineNumber<18)
        	{
        		if(screenState == 0)
        		{
        			theList.setText(theList.getText() + " |High Walk\n");
        		}
        		else if(screenState == 1)
        		{
        			theList.setText(theList.getText() + " |Drum Roll\n");
        		}
	        	lineNumber++;
	        	BUndo.setEnabled(true);
	        	BPlay.setEnabled(true);
        	}
        }
     }
    
    private class LowWalkAdd implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying&&lineNumber<18)
        	{
	        	theList.setText(theList.getText() + " |Low Walk\n");
	        	lineNumber++;
	        	BUndo.setEnabled(true);
	        	BPlay.setEnabled(true);
        	}
        }
     }
    
    private class QuickBowsAdd implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying&&lineNumber<18)
        	{
        		if(screenState == 0)
        		{
        			theList.setText(theList.getText() + " |Quick Bows\n");
        		}
        		else if(screenState == 1)
        		{
        			theList.setText(theList.getText() + " |Cleaning\n");
        		}
	        	lineNumber++;
	        	BUndo.setEnabled(true);
	        	BPlay.setEnabled(true);
        	}
        }
     }
    
    private class BowsAdd implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying&&lineNumber<18)
        	{
        		if(screenState == 0)
        		{
        			theList.setText(theList.getText() + " |Bows\n");
        		}
        		else if(screenState == 1)
        		{
        			theList.setText(theList.getText() + " |Approach\n");
        		}
	        	lineNumber++;
	        	BUndo.setEnabled(true);
	        	BPlay.setEnabled(true);
        	}
        }
     }
    
    private class clearList implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying)
        	{
	        	theList.setText("");
	        	lineNumber = 0;
	        	BUndo.setEnabled(false);
	        	BPlay.setEnabled(false);
        	}
        }
     }

    private class playRises implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying)
        	{
        		BStop.setEnabled(true);
	        	if(playing) {
		        	mp.stop();
		        	mp.release();
		        	playing = false;
	        	}
	        	mp = new MediaPlayer();
	        	mp = MediaPlayer.create(getBaseContext(), R.raw.rises);
	            mp.start();
	            playing = true;
	            mp.setOnCompletionListener(new OnCompletionListener() {
	            @Override
		            public void onCompletion(MediaPlayer mp) {
		                mp.release();
		                playing = false;
		        		BStop.setEnabled(false);
		            }
	            });
        	}
        }
     }
    
    private class playQuickBows implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying)
        	{
        		BStop.setEnabled(true);
	        	if(playing) {
		        	mp.stop();
		        	mp.release();
		        	playing = false;
	        	}
	        	mp = new MediaPlayer();
	        	if(screenState == 0)
	        	{
	        		mp = MediaPlayer.create(getBaseContext(), R.raw.quickbows);
	        	}
	        	else if(screenState == 1)
	        	{
	        		mp = MediaPlayer.create(getBaseContext(), R.raw.cleaning);
	        	}
	            mp.start();
	            playing = true;
	            mp.setOnCompletionListener(new OnCompletionListener() {
	            @Override
		            public void onCompletion(MediaPlayer mp) {
		                mp.release();
		                playing = false;
		        		BStop.setEnabled(false);
		            }
	            });
        	}
        }
     }
    
    private class playHighWalk implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying)
        	{
        		BStop.setEnabled(true);
	        	if(playing) {
		        	mp.stop();
		        	mp.release();
		        	playing = false;
	        	}
	        	mp = new MediaPlayer();
	        	if(screenState == 0)
	        	{
	        		mp = MediaPlayer.create(getBaseContext(), R.raw.hwsound);
	        	}
	        	else if(screenState == 1)
	        	{
	        		mp = MediaPlayer.create(getBaseContext(), R.raw.drumroll);
	        	}
	            mp.start();
	            playing = true;
	            mp.setOnCompletionListener(new OnCompletionListener() {
	            @Override
		            public void onCompletion(MediaPlayer mp) {
		                mp.release();
		                playing = false;
		        		BStop.setEnabled(false);
		            }
	            });
        	}
        }
     }
    
    private class playLowWalk implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying)
        	{
        		BStop.setEnabled(true);
	        	if(playing) {
		        	mp.stop();
		        	mp.release();
		        	playing = false;
	        	}
	        	mp = new MediaPlayer();
	        	mp = MediaPlayer.create(getBaseContext(), R.raw.lwsound);
	            mp.start();
	            playing = true;
	            mp.setOnCompletionListener(new OnCompletionListener() {
	            @Override
		            public void onCompletion(MediaPlayer mp) {
		                mp.release();
		                playing = false;
		        		BStop.setEnabled(false);
		            }
	            });
        	}
        }
     }
    
    private class playBows implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(!listPlaying)
        	{
        		BStop.setEnabled(true);
	        	if(playing) {
		        	mp.stop();
		        	mp.release();
		        	playing = false;
	        	}
	        	mp = new MediaPlayer();
	        	if(screenState == 0)
	        	{
	        		mp = MediaPlayer.create(getBaseContext(), R.raw.bowsound);
	        	}
	        	else if(screenState == 1)
	        	{
	        		mp = MediaPlayer.create(getBaseContext(), R.raw.approach);
	        	}
	            mp.start();
	            playing = true;
	            mp.setOnCompletionListener(new OnCompletionListener() {
	            @Override
		            public void onCompletion(MediaPlayer mp) {
		                mp.release();
		                playing = false;
		        		BStop.setEnabled(false);
		            }
	            });
        	}
        }
     }
    
    private class stopAllSound implements OnClickListener{
        @Override
        public void onClick(View v) {
           // TODO Auto-generated method stub
        	if(playing) {
	        	mp.stop();
	        	mp.release();
	        	playing = false;
        	}
        	theListChecker.setText("");
        	listPlaying = false;
        	BRises.setEnabled(true);
        	BRisesAdd.setEnabled(true);
			BBows.setEnabled(true);
			BBowsAdd.setEnabled(true);
			BQuickBows.setEnabled(true);
			BQuickBowsAdd.setEnabled(true);
			BHighWalk.setEnabled(true);
			BHighWalkAdd.setEnabled(true);
			BLowWalk.setEnabled(true);
			BLowWalkAdd.setEnabled(true);
			if(lineNumber !=0)
			{
				BUndo.setEnabled(true);
				BPlay.setEnabled(true);
			}
    		BStop.setEnabled(false);
        }
     }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    	
        switch (item.getItemId()) {
        case R.id.clear:
        	if(!listPlaying)
        	{
        		theList.setText("");
        		lineNumber = 0;
        		BUndo.setEnabled(false);
        		BPlay.setEnabled(false);
        	}
            return true;
        case R.id.routinea:
        	if(!listPlaying)
        	{
        		theList.setText(" |High Walk\n |Bows\n |High Walk\n |Low Walk\n |Approach\n |Cleaning\n |Rises\n |Quick Bows\n");
        		lineNumber = 8;
        		BUndo.setEnabled(true);
        		BPlay.setEnabled(true);
        	}
            return true;
        case R.id.quit:
        	if(!listPlaying&&!playing)
        	{
        		this.finish();
        	}
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }
}

