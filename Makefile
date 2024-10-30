kafka-up:
	docker-compose -f scripts/kafka-docker-compose.yml up -d

kafka-down:
	docker-compose -f scripts/kafka-docker-compose.yml down