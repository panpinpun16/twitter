import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class twitter {
    private final static String CONSUMER_KEY = "ZHR4gbxJe7ARHocICwxsb5ONT";
    private final static String CONSUMER_KEY_SECRET = "Qux8FhaFnBGB5TDJG55KMBMBuLxxyeGNnoAjmNPNbwXVuIngSu";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("hello Saya Irvan");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "xBfa2zd8yEfDWVpIcQKnK6mJBVnXf7W3ewIA65YilzKZF";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1140531123442765824-lMZcQuFsHMl7tC03MPwTVXf0Jc5ZKa";
    }

    public static void main(String[] args) throws Exception {
	new twitter().start();
    }
}