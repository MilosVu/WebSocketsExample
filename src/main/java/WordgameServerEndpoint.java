import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;


@ServerEndpoint(value = "/game")
public class WordgameServerEndpoint {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("Cao");
        System.out.println("conneetion opened");
    }

    @OnMessage
    public synchronized void processMessage(Session session, String
            message) {
        System.out.println(message);
    }

//    @OnMessage
//    public String onMessage(String unscrambledWord, Session session) {
//        System.out.println(unscrambledWord);
//        return unscrambledWord;
////        switch (unscrambledWord) {
////            case "start":
////                logger.info("Starting the game by sending first word");
////                String scrambledWord = WordRepository.getInstance().getRandomWord().getScrambledWord();
////                session.getUserProperties().put("scrambledWord", scrambledWord);
////                return scrambledWord;
////            case "quit":
////                logger.info("Quitting the game");
////                try {
////                    session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Game finished"));
////                } catch (IOException e) {
////                    throw new RuntimeException(e);
////                }
////        }
////        String scrambledWord = (String) session.getUserProperties().get("scrambledWord");
////        return checkLastWordAndSendANewWord(scrambledWord, unscrambledWord, session);
//    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
     //   logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

//    private String checkLastWordAndSendANewWord(String scrambledWord, String unscrambledWord, Session session) {
//        WordRepository repository = WordRepository.getInstance();
//        Word word = repository.getWord(scrambledWord);
//
//        String nextScrambledWord = repository.getRandomWord().getScrambledWord();
//
//        session.getUserProperties().put("scrambledWord", nextScrambledWord);
//
//        String correctUnscrambledWord = word.getUnscrambbledWord();
//
//        if (word == null || !correctUnscrambledWord.equals(unscrambledWord)) {
//            return String.format("You guessed it wrong. Correct answer %s. Try the next one .. %s",
//                    correctUnscrambledWord, nextScrambledWord);
//        }
//        return String.format("You guessed it right. Try the next word ...  %s", nextScrambledWord);
//    }
}