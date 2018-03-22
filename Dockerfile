FROM jboss/wildfly:10.1.0.Final
ENV JBOSS_CONFIG standalone-ha.xml
ARG NODE
ARG SCRIPT

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
ADD customization /opt/jboss/wildfly/customization

RUN /opt/jboss/wildfly/customization/$SCRIPT standalone $JBOSS_CONFIG

RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current
CMD  /opt/jboss/wildfly/bin/standalone.sh -c $JBOSS_CONFIG -b 0.0.0.0 -bmanagement 0.0.0.0 -u 230.0.0.4 $NODE
