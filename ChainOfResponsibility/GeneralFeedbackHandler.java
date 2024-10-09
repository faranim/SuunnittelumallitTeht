package ChainOfResponsibility;

// GeneralFeedbackHandler.java
public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (canHandle(message)) {
            System.out.println("Analyzing general feedback: " + message.getContent());
            // General feedback logic
        } else {
            super.handle(message);
        }
    }

    @Override
    protected boolean canHandle(Message message) {
        return message.getType().equals(Message.getGeneralFeedbackType());
    }
}

