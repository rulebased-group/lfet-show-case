package de.lfet.demo.application;

import de.lfet.demo.common.DecisionTableGroupTraceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// tag::showCaseService[]
class LFETShowCaseService implements LFETShowCaseUseCase, LFETShowCase_Iface<LFETShowCaseService.LFETProcessingModel> {

    final LFETShowCase_RulesEngine rulesEngine;

    @Override
    public boolean __isAlter(String symbol, String title, double titleMin, double titleMax, LFETProcessingModel model) {
        return model.input.getAlter() >= titleMin && model.input.getAlter() <= titleMax;
    }

    @Override
    public boolean __isAbgeschlossenerTarif(String symbol, String title, String text, LFETProcessingModel model) {
        return model.input.getTarif().equals(symbol);
    }

    @Override
    public void __doMeldung(String symbol, String title, String text, LFETProcessingModel model) {
        model.result.addMeldung(new Meldung(symbol, title));
    }

    @Override
    public void __doTrace(String dtName, String version, int rules, int rule, LFETProcessingModel model) {
        DecisionTableGroupTraceModel decisionTable = DecisionTableGroupTraceModel.of(new DecisionTableGroupTraceModel.DecisionTableName(dtName), new DecisionTableGroupTraceModel.DecisionTableVersion(version), new DecisionTableGroupTraceModel.DecisionTableRule(rules));
        model.result.addLfetTrace(decisionTable, new DecisionTableGroupTraceModel.DecisionTableRule(rule));
    }

    @Override
    public LFETDemoUseCaseResultModel execute(LFETDemoUseCaseCommand input) {
        LFETProcessingModel lfetDemoServiceModel = new LFETProcessingModel(input, new LFETDemoUseCaseResultModel());
        rulesEngine.execute(this, lfetDemoServiceModel);
        return lfetDemoServiceModel.result;
    }

    @RequiredArgsConstructor
    static class LFETProcessingModel {

        final LFETDemoUseCaseCommand input;
        final LFETDemoUseCaseResultModel result;

    }
}
// end::showCaseService[]