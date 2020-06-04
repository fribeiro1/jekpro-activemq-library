/*
 * Copyright 2015 Fernando Ribeiro
 * 
 * This file is part of ActiveMQ Library.
 *
 * ActiveMQ Library is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * ActiveMQ Library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with ActiveMQ Library. If not, see <http://www.gnu.org/licenses/>.
 */
package br.eti.fernandoribeiro.jekpro.activemq;

import java.io.PrintWriter;
import java.io.Writer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import jekpro.platform.headless.ToolkitLibrary;
import jekpro.tools.api.Interpreter;
import jekpro.tools.api.InterpreterMessage;
import jekpro.tools.api.TermRef;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQLibrary {

	public static void closeConnection(Object connection)
			throws InterpreterMessage {

		try {
			((Connection) connection).close();
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't close connection"));
		}

	}

	public static Object createConnection(Object connectionFactory)
			throws InterpreterMessage {

		try {
			return ((ConnectionFactory) connectionFactory).createConnection();
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create connection"));
		}

	}

	public static Object createConnectionFactory() {
		return new ActiveMQConnectionFactory();
	}

	public static Object createConsumer(Object session,
			Object destination) throws InterpreterMessage {

		try {
			return ((Session) session)
					.createConsumer((Destination) destination);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create consumer"));
		}

	}

	public static Object createDurableSubscriber(Object session,
			Object topic, String name) throws InterpreterMessage {

		try {
			return ((Session) session).createDurableSubscriber((Topic) topic,
					name);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage
							.systemError("Can't create durable subscriber"));
		}

	}

	public static Object createProducer(Object session,
			Object destination) throws InterpreterMessage {

		try {
			return ((Session) session)
					.createProducer((Destination) destination);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create producer"));
		}

	}

	public static Object createQueue(Object session,
			String queueName) throws InterpreterMessage {

		try {
			return ((Session) session).createQueue(queueName);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create queue"));
		}

	}

	public static Object createSession(Object connection,
			String transacted, Integer acknowledgeMode)
			throws InterpreterMessage {

		try {
			return ((Connection) connection).createSession(
					Boolean.valueOf(transacted), acknowledgeMode);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create session"));
		}

	}

	public static Object createTextMessage(Object session,
			String text) throws InterpreterMessage {

		try {
			return ((Session) session).createTextMessage(text);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create text message"));
		}

	}

	public static Object createTopic(Object session,
			String topicName) throws InterpreterMessage {

		try {
			return ((Session) session).createTopic(topicName);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't create topic"));
		}

	}

	public static void printMessage(Interpreter interpreter,
			Object message) {
		PrintWriter out = new PrintWriter(
				(Writer) ((TermRef) interpreter
						.getProperty(ToolkitLibrary.PROP_SYS_CUR_OUTPUT))
						.getValue());

		out.println(message);
	}

	public static Object receiveMessage(Object consumer)
			throws InterpreterMessage {

		try {
			return ((MessageConsumer) consumer).receive();
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't receive message"));
		}

	}

	public static void sendMessage(Object producer, Object message)
			throws InterpreterMessage {

		try {
			((MessageProducer) producer).send((Message) message);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't send message"));
		}

	}

	public static void setClientID(Object connection,
			String clientID) throws InterpreterMessage {

		try {
			((Connection) connection).setClientID(clientID);
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't set client ID"));
		}

	}

	public static void startConnection(Object connection)
			throws InterpreterMessage {

		try {
			((Connection) connection).start();
		} catch (JMSException e) {
			throw new InterpreterMessage(
					InterpreterMessage.systemError("Can't start connection"));
		}

	}

}