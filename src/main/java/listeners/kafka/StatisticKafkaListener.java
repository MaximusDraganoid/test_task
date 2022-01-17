package listeners.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.maslov.dto.KafkaMessageDto;

@Service
public class StatisticKafkaListener {

    @KafkaListener(topics="statistic")
    public void messageListener(ConsumerRecord<Long, KafkaMessageDto> record) {

        KafkaMessageDto messageDto = (KafkaMessageDto) record.value();
        System.out.println("Answer will save or send to user with id + " + messageDto.getMessageId());
        //todo: написать отвправление ответа тоже в како-либо топик кафки - сообщение ответа содержит
        // необходимую информацию и идентификатор пользователя (в нашем случае message id)
    }
}
