package ru.maslov.kafka.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.maslov.clients.CurrencyClient;
import ru.maslov.dto.CurrencyDTO;
import ru.maslov.dto.KafkaMessageDto;

@Service
public class StatisticKafkaListener {

    private final String appId;
    private final String currency;
    private final CurrencyClient currencyClient;

    @Autowired
    private KafkaTemplate<Long, String> kafkaMessageTemplate;

    public StatisticKafkaListener(CurrencyClient currencyClient,
                                  @Value("${openexchangerates.app.id}") String appId,
                                  @Value("${currency}") String currency) {
        this.currencyClient = currencyClient;
        this.appId = appId;
        this.currency = currency;
    }

    @KafkaListener(topics = "statistic")
    public void messageListener(ConsumerRecord<Long, KafkaMessageDto> record) {


        KafkaMessageDto messageDto = record.value();
        System.out.println("processing message");
        CurrencyDTO startCurrency = currencyClient.getCurrency(messageDto.getStartDate(), appId, messageDto.getCurrency());
        CurrencyDTO endCurrency = currencyClient.getCurrency(messageDto.getStartDate(), appId, messageDto.getCurrency());
        System.out.println("Answer will save or send to user with id + " + messageDto.getMessageId());
        kafkaMessageTemplate.send("answers", messageDto.getMessageId(), messageDto.toString());

        //todo: написать отвправление ответа тоже в како-либо топик кафки - сообщение ответа содержит
        // необходимую информацию и идентификатор пользователя (в нашем случае message id)
    }
}
