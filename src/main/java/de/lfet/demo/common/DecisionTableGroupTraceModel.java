package de.lfet.demo.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DecisionTableGroupTraceModel {

    DecisionTableName decisionTableName;
    DecisionTableVersion version;
    DecisionTableRule max;

    public static DecisionTableGroupTraceModel of(DecisionTableName name, DecisionTableVersion version, DecisionTableRule maxRules) {
        return new DecisionTableGroupTraceModel(name, version, maxRules);
    }


    @Value
    public static class DecisionTableName {
        String value;
    }

    @Value
    public static class DecisionTableVersion {
        String value;
    }

    @Value
    public static class DecisionTableRule {
        long value;
    }

}