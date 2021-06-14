package de.lfet.demo.application;

import de.lfet.demo.common.DecisionTableGroupTraceModel;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LFETShowCaseUseCase {

    LFETDemoUseCaseResultModel execute(LFETDemoUseCaseCommand input);

    @ToString
    @Getter
    class LFETDemoUseCaseResultModel {

        Map<DecisionTableGroupTraceModel, List<DecisionTableGroupTraceModel.DecisionTableRule>> decisionTableTraceModel;
        List<Meldung> meldungen;

        LFETDemoUseCaseResultModel() {
            this.decisionTableTraceModel = new HashMap<>();
            this.meldungen = new ArrayList<>();
        }

        void addLfetTrace(DecisionTableGroupTraceModel decisionTable, DecisionTableGroupTraceModel.DecisionTableRule currentRule) {
            List<DecisionTableGroupTraceModel.DecisionTableRule> rules = decisionTableTraceModel.computeIfAbsent(decisionTable, k -> new ArrayList<>());
            rules.add(currentRule);
        }

        void addMeldung(Meldung meldung) {
            this.meldungen.add(meldung);
        }

        public boolean hasMeldungen() {
            return this.meldungen.size() > 0;
        }

    }

    @Value
    class Meldung {
        String id;
        String description;

        public String toString() {
            return String.format("%s - %s", id, description);
        }
    }

    @Value
    class LFETDemoUseCaseCommand {

        double alter;
        String tarif;

    }
}
